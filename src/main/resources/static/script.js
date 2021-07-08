
// Make an AJAX call
// function retrieveQuestions() {

//     console.log("fethcing quiz questions with AJAX");
//     let xhr = new XMLHttpRequest();

//     xhr.open('GET', "http://localhost:5000/questions")
//     xhr.send();
//     xhr.onreadystatechange = function() {
//         if (xhr.readyState == 4 && xhr.status == 200) {
//             // set some varibale that's equal an element on our html page = JSON.parse(xhr.responseText)
//             var quizQuestions = JSON.parse(xhr.responseText)
//             // trigger a function to build the quiz and display it on the screen
//             buildQuiz(quizQuestions)
//         }
//     }
// }





window.onload = () => {

    // Dynamically create HTML elements needed for the page
    let quizDiv = document.createElement('div');    
    let resultsDiv = document.createElement('div');
    let buttonDiv = document.createElement('div');
    let submitBtn = document.createElement('button');

    // We can also create and set attrbiutes to the newly created elements
    quizDiv.setAttribute('id', 'quiz');
    resultsDiv.setAttribute('id', 'results')
    buttonDiv.setAttribute('id', 'button-container');
    buttonDiv.style.padding = '2px';
    buttonDiv.style.cssFloat = 'left';

    submitBtn.setAttribute('id', 'submit');
    submitBtn.setAttribute('class', 'btn btn-primary');

    // Add some text to the button
    submitBtn.innerText = "Submit Quiz"

    // append and prepend the newly created elements to the newly craeeted page
    buttonDiv.appendChild(submitBtn);
    document.prepend(resultsDiv);
    document.prepend(buttonDiv);
    document.prepend(quizDiv);

    // Add event listeners for vlaidating and grading the quiz
    buttonDiv.addEventListener('mouseover', isQuizValid); // TODO build these functions
    submitBtn.addEventListener('click', showResults); // TODO


}


async function buildQuiz() {

    let questionsPromise = await getQuestions;
    let questions = await questionsPromise;

    // within this method lets call PRE-Initialied elements on our html page and populate them with the individual elements 
    // of getQuestions.

    let quizContainer = document.getElementById('quiz');

    // Create an empty array to hold all htm  which we will eventually render
    const output = []; // even though I can't set output to a separate type, I can change the properties of the object that it points to

    // Loop through the questions and build HTML for each question
    questions.array.forEach((currentQuestion, questionNumber) => {
        
        // creaete an array for storing each question's answer
        const answers = [];

        // create a label for each answer within the question and add it to the answers array -> 2 ways: basic loop, JS enhanced for loop (let n in numbers)
        for(let letter in currentQuestion['questionsAnswers']) { // in JS you can access a property of an object with obj['property']

            answers.push(`
            <label>
                <input type="radio" name="question-${questionNumber}" value="${letter}"/>
                ${letter.charAt(letter.length - 1).toLowerCase()}: ${currentQuestion['questionAnswers'][letter]}
            </label>
            <br/>
            `);
        }

        // add this question and its answers to the output array
        output.push(`
        <br/>
        <div class="question">${currentQuestion['questionText']}</div>
        <div class="answers">${answers.join('')}</div>
        `) // join() transforms an array into a string


        // combine our output array into one string of HTM<  and put it on the page
        quizContainer.innerHTML = output.join('');

    });





}



// way with fetch
let getQuestions = (async function() {

    let myQuestions; // this qill be an array of JSON object that we retrieve

    return async function() {
        if (!!myQuestions) { // here we're checking to see if myQuestions is defined or not (truthy or falsey)
            console.log("already retirieved the questions...not doing it again");
            return myQuestions;
        } else {
            console.log("Retrieving the questions using Fetch!")

            try {

                // await is a keyword that can ONLY be use within an aync block 
                let response = await fetch("http://localhost:5000/questions");
                myQuestions = await response.json(); // await is used to wait for a promise to be returned
                console.log(myQuestions);
                return myQuestions;

            } catch {
                console.error('Could not retrieve data from the API!');
            }
        }
    }
})();
