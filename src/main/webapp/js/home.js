//This is dummy data until the call to the backend can be made
var incomingData = {
    "name": "Lindsay Elliott",
    "UID": 666,
    "userType": "CLIENT",
    "medalsEarned": 12,
    "medalStreak": 2,
    "upcomingPills": [
        {
            "pillName": "Advil",
            "pillID": 1,
            "pillTime": "1:00 PM",
            "pillDosage": "35 kg",
            "pillInfo": "This is meant to be taken with food.",
        },
        {
            "pillName": "Tylenol",
            "pillID": 666,
            "pillTime": "4:00 PM",
            "pillDosage": "100 mg",
            "pillInfo": "Take however you want.",
        },
        {
            "pillName": "Paracetamol",
            "pillID": 12,
            "pillTime": "5:00 PM",
            "pillDosage": "69 g",
            "pillInfo": "Make sure you are well rested first.",
        }
    ],
    "unmarkedPills": [
        {
            "pillName": "Advil",
            "unmarkedPillID": 2,
            "pillDate": "Nov. 19th @ 4:00 PM",
            "pillDosage": "100 g",
        },
        {
            "pillName": "ZQuill",
            "unmarkedPillID": 3,
            "pillDate": "Nov. 20th @ 5:00 AM",
            "pillDosage": "150 mg",
        },
        {
            "pillName": "Tylenol",
            "unmarkedPillID": 4,
            "pillDate": "Nov. 20th @ 1:00 PM",
            "pillDosage": "75 mg",
        }
    ]
}

$(document).ready(function() {

    //Call backend function
    $.get("./dashboard?uid=1",function(retVal){
        incomingData = retVal;
        console.log(incomingData);
        loadTodaysPills(incomingData.upcomingPills);
        loadUnmarkedPills(incomingData.unmarkedPills);

        //Welcome name and medal count
        document.getElementById("welcomeName").innerHTML = "Welcome " + incomingData.name + "!";
        document.getElementById("medalCountMessage").innerHTML = "Medals: " + incomingData.medalsEarned;

        //Medal progression
        document.getElementById("medalStreakMessage").innerHTML = "Take your medication for 7 days in a row without missing any to get a new medal! You have currently taken your medication for " + incomingData.medalStreak + " day(s) stright!";
        document.getElementById("medalProgress").innerHTML = incomingData.medalStreak;
        document.getElementById("medalProgress").setAttribute('aria-valuenow', incomingData.medalStreak);
        var percent = Math.round(incomingData.medalStreak / 0.07);
        document.getElementById("medalProgress").setAttribute('style', 'width:' + percent + '%;  font-size:18px; padding:6px; color:black;');
    });
});

$('#menu-home').click(function (){location.href = "./home"});
$('#logo').click(function (){location.href = "./home"});
$('#menu-profile').click(function (){location.href = "./profile"});
$('#menu-schedule').click(function (){location.href = "./schedule"});
$('#menu-messages').click(function (){location.href = "./messages"});
$('#menu-links').click(function (){location.href = "./links"});
$('#menu-settings').click(function (){location.href = "./settings"});
$('#menu-logout').click(function (){location.href = "./logout"});

function openPillInfo(pillName, pillInfo) {
    document.getElementById("pillInfoName").innerHTML = pillName;
    document.getElementById("pillInfoInfo").innerHTML = pillInfo;
    $('#pillInfo').modal();
}

function loadTodaysPills(todaysPills) {
    for(i = 0; i < todaysPills.length; i ++) {
        // location.href = "index.html"
        var source   = document.getElementById("todays_pills").innerHTML;
        var template = Handlebars.compile(source);

        var tempData = {pillName: todaysPills[i].pillName, pillInfo: todaysPills[i].pillInfo, pillDosage: todaysPills[i].pillDosage, pillTime: todaysPills[i].pillTime,  pillID: todaysPills[i].pillID};
        var html = template(tempData);

        document.getElementById("no-pills-today").hidden = true;

        $($('#todays-pills-container').children()[$('#todays-pills-container').children().length - 1]).removeClass("last-past-pill-item");
        $('#todays-pills-container').append(html);
    }
}

function loadUnmarkedPills(unmarkedPills) {
    for(i = 0; i < unmarkedPills.length; i ++) {
        var source   = document.getElementById("missed_pills").innerHTML;
        var template = Handlebars.compile(source);

        var tempData = {pillName: unmarkedPills[i].pillName, pillDosage: unmarkedPills[i].pillDosage, pillDate: unmarkedPills[i].pillDate,  pillID: unmarkedPills[i].unmarkedPillID};
        var html = template(tempData);

        $($('#missed-pills-container').children()[$('#missed-pills-container').children().length - 1]).removeClass("last-past-pill-item");
        $('#missed-pills-container').append(html);
    }

    if(unmarkedPills.length == 0) {
        $('#missed-pills-container').append("<div id='empty-past-pills' style='margin-top:80px; text-align:center; padding-left:5px; padding-right:5px;'>" +
            "<p>You have marked all past pills as taken or missed! Keep up the good work!</p></div>");
    }
}

function markPill(unmarkedPillID, taken) {
    //pass pillID and boolean to backend team!
    console.log("PillID: " + unmarkedPillID + ", taken: " + taken);
    for(i = 0; i < incomingData.unmarkedPills.length; i ++) {
        if (incomingData.unmarkedPills[i].unmarkedPillID == unmarkedPillID) {
            incomingData.unmarkedPills.splice(i,1);
        }
    }

    $('#missed-pills-container').empty();
    loadUnmarkedPills(incomingData.unmarkedPills);
}
