document.getElementById("shorten-form").addEventListener("submit", async function (event) {
    event.preventDefault();
    const originalUrl = document.getElementById("originalUrl").value;

    const response = await fetch("http://localhost:8080/api/shorten", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({originalUrl}),
    });

    if (response.ok) {
      const shortUrl = await response.text();
      document.getElementById(
        "short-url"
      ).innerHTML = `Short URL: <a href="http://localhost:8080/api/${shortUrl}">http://localhost:8080/api/${shortUrl}</a>`;
    } else {
      document.getElementById("short-url").innerText = "Error shortening URL.";
    }
  });