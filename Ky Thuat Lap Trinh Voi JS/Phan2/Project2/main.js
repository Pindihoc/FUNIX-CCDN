// Setting counter at first
var counter = 0;

// Function record
function record() {

    var testScore = {
        name: "",
        math: 0,
        physical: 0,
        chemistry: 0
    };

    // Adding counter by 1
    ++counter;

    // Adding mark records
    for (const key in testScore) {
        testScore[key] = document.getElementById(key).value;
        document.getElementById(key).value = "";
    }

    // Calculating average mark
    var averageMark = 0.0,
        sum = 0.0;

    for (const key in testScore) {
        var val = parseFloat(testScore[key]);
        if (!isNaN(val)) {
            sum += val;
        }
    }

    averageMark = (sum / (Object.keys(testScore).length - 1)).toFixed(1);

    // Creating table
    var myTab = document.getElementById("myTab");
    var row = myTab.insertRow(-1);
    var len = Object.keys(testScore).length + 1;

    for (let i = 0; i <= len; i++) {
        if (i == 0) {
            row.insertCell(i).innerHTML = counter;
        } else {
            for (const key in testScore) {
                if (testScore[key] == "") {
                    continue;
                } else {
                    row.insertCell(i).innerHTML = testScore[key];
                    testScore[key] = "";
                    break;
                }
            }
        }

        // Adding average mark and putting it to hidden mode
        if (i == len) {
            row.insertCell(i).setAttribute('id', 'averageMark' + counter).setAttribute('class', 'averageMark');
            //document.getElementById('averageMark'+counter).setAttribute('class', 'averageMark');
            document.getElementById('averageMark' + counter).innerHTML = averageMark;
            document.getElementById('averageMark' + counter).style.visibility = 'hidden';
        }
    }
}

function averageMarkCalc() {
    var elements = document.getElementsByClassName('averageMark');
    for (var i = 0; i < elements.length; i++) {
        elements[i].style.visibility = 'visible';
    }
}

function greatStudIdentify() {
    var rows = document.getElementById('table').rows;
    var elements = document.getElementsByClassName('averageMark');
    for (var i = 0; i < elements.length; i++) {
        var val = parseFloat(elements[i].textContent)
        if (val >= 8.0) {
            rows[i + 1].style.color = "red";
        }
    }
}