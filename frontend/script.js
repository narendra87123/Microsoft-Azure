document.getElementById('careerForm').addEventListener('submit', function(e) {
    e.preventDefault();
    const name = document.getElementById('name').value;
    const skills = document.getElementById('skills').value;

    fetch('http://localhost:8080/api/career-advice', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ name: name, skills: skills })
    })
    .then(response => response.json())
    .then(data => {
        document.getElementById('advice').innerText = data.advice;
    });
});