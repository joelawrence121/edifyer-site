chrome.tabs.query({active: true, lastFocusedWindow: true}, tabs => {
    let url = tabs[0].url;
    
    const comp = document.getElementById("companyname");
    
    url = url.replace(/https?:\/\/w?w?w?\.?/i, "");//[^\/] replace anything not / with ""
    url = url.replace(/\.com|\.io|\.net|\.co.uk|\.info/i, "");

    url = url.replace(/\/[\S]*/, "");
    comp.href="http://www.edifyer.com/process.php?companyname=" + url;
    url = url.charAt(0).toUpperCase() + url.slice(1)+":";
    comp.innerText = url;
    

    let comp_score = 50;
    const score_element = document.getElementById("compscore");
    score_element.innerText=comp_score;

});