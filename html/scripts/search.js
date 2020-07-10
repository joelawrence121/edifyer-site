

//console.log(passedArray[1][0].substr(0,passedArray[1][0].indexOf(' ')));
console.log(passedArray[1][0]);
var i;
const people = []

for (i=0; i < passedArray.length; i++){
    people.push({ name: passedArray[i][0]});//get string up till first space
}
console.log(people);
const list = document.getElementById('list');

function setList(group){//group is search results
    clearList();
    for (const person of group){
        const item = document.createElement('li');
        //const text = document.createTextNode(person.name);
        /*var a = document.createElement("a");
        a.textContent = person.name;
        a.setAttribute('href', person.name+".html");*/
        
        var x = document.createElement("FORM");
        x.setAttribute("id", "myForm");
        x.setAttribute("method", "post");
        x.setAttribute("action", "process.php");

        var y = document.createElement("INPUT");
        y.setAttribute("type", "submit");
        y.setAttribute("value", person.name);
        y.setAttribute("name", "companyname");
        x.appendChild(y);
        item.appendChild(x);
        list.appendChild(item);
    }
    if (group.length===0){
        setNoResults();
    }
}
function clearList(){
    while (list.firstChild){
        list.removeChild(list.firstChild);
    }
}
function setNoResults(){
    const item = document.createElement('li');
    const text = document.createTextNode('We haven\'t analysed that company yet!');
    item.appendChild(text);
    list.appendChild(item);
}
function getRelevancy(value, searchTerm){
    if (value===searchTerm){
        return 2;
    }
    else if (value.startsWith(searchTerm)){
        return 1;
    }
    else if (value.includes(searchTerm)){
        return 0;
    }
    else {
        return -1;
    }
}
const searchInput = document.getElementById('search');
searchInput.addEventListener('input', (event)=> {
    let value = event.target.value;
    if (value && value.trim().length>0){
        value = value.trim().toLowerCase();
        setList(people.filter(person => {
            return person.name.includes(value);
        }).sort((personA, personB)=> {
            return getRelevancy(personB.name, value) -getRelevancy(personA, value);
        }));
    }
    else {
        clearList();
    }
});