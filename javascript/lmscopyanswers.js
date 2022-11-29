let answersamount = 10;
let qid = "q2288869";
let answers = [];
for (let i = 0; i < answersamount; i++) {
  answers.push(document.getElementById(qid + ":" + (i + 1) + "_answer").value);
}
console.log(answers);

let answersamount = 10;
let qid = "q2288869";
for (let i = 0; i < answersamount; i++) {
  let val = answers[i];
  document.getElementById(qid + ":" + (i + 1) + "_answer").value = val;
}
