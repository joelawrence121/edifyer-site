
let seconds = 0;
let minutes = 0;
let hours = 0;
//Define vars to hold "display" value
let displaySeconds = 0;
let displayMinutes = 0;
let displayHours = 0;

const companyName = document.getElementById("companyname").innerHTML.trim();
var i;
var companyScore = 0;
console.log(companyName);
for (i = 0; i<companyscorearray.length; i++){
  console.log(companyscorearray[i][0]);
  if (companyName==companyscorearray[i][0]){
    companyScore = companyscorearray[i][1];
  }
}
console.log(companyScore);
//const companyScore = 77;
//document.getElementById("companyname").innerHTML = companyName;
//Define var to hold setInterval() function
let interval = null;

//Define var to hold stopwatch status
let status = "stopped";
var circle = document.querySelector('circle');
var radius = circle.r.baseVal.value;
var circumference = radius * 2 * Math.PI;
circle.style.strokeDasharray = `${circumference} ${circumference}`;
circle.style.strokeDashoffset = `${circumference}`;

function setProgress(percent) {
  const offset = circumference - percent / 100 * circumference;
  circle.style.strokeDashoffset = offset;
}

//const input = document.querySelector('input');
//setProgress(input.value);
//Stopwatch function (logic to determine when to increment next value, etc.)
function stopWatch(){
    if (seconds < companyScore){
        seconds++;
        if (seconds < 101 && seconds > -1) {
          setProgress(seconds);
        }  
    }

    if(seconds < 10){
        displaySeconds = "0" + seconds.toString();
    }
    else{
        displaySeconds = seconds;
    }
    document.getElementById("display").innerHTML = displaySeconds;

}



function startStop(){

    if(status === "stopped"){

        //Start the stopwatch (by calling the setInterval() function)
        interval = window.setInterval(stopWatch, 50);
        //document.getElementById("startStop").innerHTML = "Stop";
        status = "started";

    }
    

}


/*input.addEventListener('change', function(e) {
  if (input.value < 101 && input.value > -1) {
    setProgress(input.value);
  }  
})*/