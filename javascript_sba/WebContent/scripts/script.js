/**We will define in more detail what is this “document” object
For now, line 1, is grabbing an HTML element that has an attribute id with value “form” and storing it in a 
variable name “element”
For now, line 2, is grabbing an HTML element that has an attribute id with value “feedback” and storing it in
 a variable name “ele”
Javascript has the ability to listen for event. Line 3 checks if any kind of event happen to the element stored
 in variable “element”
If so, then we check on a specific type of event “submit”, and a custom function to handle this event. This is line 5
The next if statement is doing the same thing as the first one but this way f doing it is for other versions

 * 
 */
var element = document.getElementById("form");
var ele = document.getElementById("feedback");
if (element.addEventListener){
    //modern browsers
    element.addEventListener("submit", main_validator, true);
}else if (ele.attachEvent){
    //Old IE
    element.attachEvent('onsubmit', main_validator);
}

/*This is the custom function being called once the event happens. If you go back to the previous slide, 
the function was called without a parameters, not even parentheses. What’s going on?
Javascript is weird like that!! Since we pass the “main_validator” function to an event listener, 
we don’t need to pass any parameters, not even the parentheses
However, Javascript passes one single parameter, the event object itself. This object contains everything 
you need to know about the current event
Since, we like to do validation with Javascript before the form is submitted. We call the preventDefault() 
from the event. This will cause the form not not submit 
Line 14, this variable contains a element with attribute id and value feedback. This variable is calling innerHTML, 
which is the content inside this container. And sets is to empty string, to clear the content 

The if statement is calling two custom methods that return true or false. This depend if the input fields were
 valid or invalid
The “e.target[0].value” refers to the value (text) first input field inside the form. 
This is the username input field

*/
function main_validator(e) {
    console.log(e)
    e.preventDefault();
    ele.innerHTML = "";
    if (check_username(e.target[0].value)
        && check_dob (e.target[1].value)
){
            element.submit();
        }
}

/*Line 22, is our lovely regular expression checking for only letters, number, _, or -
The message variable is where the entire invalid message is stored and the someWrong variable tells us if something is invalid
The if statement in line 26, is testing if there is not a match
The if statement in line 30, is testing if the username is longer than 20 character
Now line 34, if something is invalid then
create an HTML element <p> and store is in a variable “para”
Then access the list of classes of the <p> tag and add a new class called danger (Initially the <p> tags has no class)
Create a text object (this is just a HTML string that can be inserted inside an HTML element)
Then add the text to the <p> tag
Then add the <p> tag to the “feedback” element
Finally, return false because something was invalid
Lastly, if everything went well, return true
*/

function check_username (username) {
    var re = new RegExp(/^[a-zA-Z0-9_.-]*$[a-zA-Z_.-]*$/); 
    var message = "";
    var someWrong = false;
    console.log(re.test(username))
    if(!re.test(username)){
        message += "Username can only be [a-z], [A-Z], or (-,_)";
        someWrong = true;
    }
    if(username.length > 20) {
        message += "\nUsername must be less than 20 characters";
        someWrong = true;
    }
    if(someWrong){
        //Create a <p> element
        var para = document.createElement("P");
        para.classList.add("danger");
        //Create a text node
        var t = document.createTextNode(message);
        para.appendChild(t);
        ele.appendChild(t);
        return false;
    }
    return true;
}

/*Similar logic is implement here. Note that the regular expression is one line as the comment states
Line 49, is a expression checking for a well formatted date
The message variable is where the entire invalid message is stored and the someWrong variable tells us if something is invalid
The if statement in line 52, is testing if there is not a match
Line 56, if something is invalid then
create an HTML element <p> and store is in a variable “para”
Then access the list of classes of the <p> tag and add a new class called danger (Initially the <p> tags has no class)
Create a text object (this is just a HTML string that can be inserted inside an HTML element)
Then add the text to the <p> tag
Then add the <p> tag to the “feedback” element
Finally, return false because something was invalid
Lastly, if everything went well, return true
*/

function check_dob(dob){
    //this is one line
    var re = new RegExp(/(\d+)(-|\/)(\d+)(?:-|\/)(?:(\d+)\s+(\d+):(\d+)(?::(\d+))?(?:\.(\d+))?)?/);
    var message = "";
    var someWrong = false;
    if (!re.test(dob)){
        message += "Your date of birth is not in the right format";
        someWrong = true;
    }
    if(someWrong){
    //create a <p> element
    var para = document.createElement("P");
    para.classList.add("danger");
    //create a text node
    var t = document.createTextNode(message);
    para.appendChild(t);
    ele.appendChild(para);
    return false;
    }
}
