function sendEmail() {

  var request = new XMLHttpRequest();
  request.open("GET", "./dataset.json", false);
  request.send(null);
  var dataset = JSON.parse(request.responseText);
  for (let i = 0; i < dataset.length; i++) {
    var templateParams = {
      from_name: "Московский Политехнический Университет",
      to_name: dataset[i].name,
      to_email: dataset[i].email,
      event_type: document.getElementById("event_type").value,
      event_name: document.getElementById("event_name").value,
      subject:
        "Приглашение на участие в " +
        document.getElementById("event_type").value,
    };

    emailjs.send("service_o5ifesk", "template_6be4fud", templateParams).then(
      function (response) {
        console.log("success!", response.status, response.text);
      },
      function (error) {
        console.log("failed ", error);
      }
    );
  }
}
