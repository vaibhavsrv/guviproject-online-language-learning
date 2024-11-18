function showCourses() {
  alert("Courses coming soon!");
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
