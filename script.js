function showCourses() {
  alert("Courses coming soon!");
}

function login() {
  const username = document.getElementById("username").value;
  const password = document.getElementById("password").value;

  fetch("http://localhost:8080/login", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ username, password })
  })
    .then((response) => response.json())
    .then((data) => {
      const message = document.getElementById("loginMessage");
      if (data.success) {
        message.textContent = "Login successful! Welcome, " + username;
        message.style.color = "green";
      } else {
        message.textContent = "Invalid username or password!";
        message.style.color = "red";
      }
    })
    .catch((error) => console.error("Error:", error));
}

// Detecting visible sections for animation
document.addEventListener("DOMContentLoaded", () => {
  const sections = document.querySelectorAll("section");

  const onScroll = () => {
    sections.forEach((section) => {
      const rect = section.getBoundingClientRect();
      if (rect.top < window.innerHeight - 100) {
        section.classList.add("visible");
      }
    });
  };

  // Trigger animations on load and scroll
  window.addEventListener("scroll", onScroll);
  onScroll(); // Initial check
});
