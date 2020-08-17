
let seconds = 0;
let minutes = 0;
let hours = 0;
//Define vars to hold "display" value
let displaySeconds = 0;
let displayMinutes = 0;
let displayHours = 0;

const companyName = document.getElementById("companyname").innerHTML.trim();
var i;
var companyScore = document.getElementById("hidden-score").innerHTML;
console.log(companyScore);



let interval = null;


let status = "stopped";
var circle = document.querySelector('circle');
var radius = circle.r.baseVal.value;
var circumference = radius * 2 * Math.PI;
circle.style.strokeDasharray = `${circumference} ${circumference}`;
circle.style.strokeDashoffset = `${circumference}`;

let status1 = "stopped";
var circle1 = document.getElementById('circlefact1');
var radius1 = circle1.r.baseVal.value;
var circumference1 = radius1 * 2 * Math.PI;
circle1.style.strokeDasharray = `${circumference1} ${circumference1}`;
circle1.style.strokeDashoffset = `${circumference1}`;
let status2 = "stopped";
var circle2 = document.getElementById('circlefact2');
var radius2 = circle2.r.baseVal.value;
var circumference2 = radius2 * 2 * Math.PI;
circle2.style.strokeDasharray = `${circumference2} ${circumference2}`;
circle2.style.strokeDashoffset = `${circumference2}`;

function setProgress(percent) {
  const offset = circumference - percent / 100 * circumference;
  circle.style.strokeDashoffset = offset;
const offset1 = circumference1 - percent / 100 * circumference1;
  circle1.style.strokeDashoffset = offset1;
const offset2 = circumference2 - percent / 100 * circumference2;
  circle2.style.strokeDashoffset = offset2;
}

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
     let factclass = document.getElementsByClassName("factclass");
	//factclass[0].innerHTML=displaySeconds;
	let i;
	for (i = 0; i<factclass.length; i++){
		factclass[i].innerHTML = displaySeconds;
	}
	//factclass.foreach(factor => factor.innerHTML=displaySeconds);


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