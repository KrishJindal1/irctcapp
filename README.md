<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Terminal-Based IRCTC Booking System — README</title>
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600;700;800&display=swap" rel="stylesheet">
  <style>
    :root{
      --bg:#0f172a; /* dark navy */
      --card:#0b1220;
      --muted:#94a3b8;
      --accent:#06b6d4; /* cyan */
      --accent-2:#7c3aed; /* purple */
      --glass: rgba(255,255,255,0.03);
      --radius:14px;
      font-family: 'Inter', system-ui, -apple-system, 'Segoe UI', Roboto, 'Helvetica Neue', Arial;
    }
    html,body{height:100%;margin:0;background:linear-gradient(180deg,#071128 0%, #071026 60%);color:#e6eef6}
    .container{max-width:980px;margin:48px auto;padding:28px;background:linear-gradient(180deg, rgba(255,255,255,0.02), rgba(255,255,255,0.01));border-radius:18px;box-shadow:0 8px 30px rgba(2,6,23,0.6);border:1px solid rgba(255,255,255,0.03)}

    header{display:flex;gap:18px;align-items:center}
    .logo{width:68px;height:68px;border-radius:12px;background:linear-gradient(135deg,var(--accent),var(--accent-2));display:grid;place-items:center;font-weight:800;color:white;font-size:26px;box-shadow:0 6px 18px rgba(124,58,237,0.18)}
    h1{font-size:22px;margin:0}
    p.lead{color:var(--muted);margin-top:6px}

    .badges{display:flex;gap:8px;margin-left:auto}
    .badge{background:var(--glass);padding:6px 10px;border-radius:999px;font-size:13px;color:var(--muted);border:1px solid rgba(255,255,255,0.02)}

    .grid{display:grid;grid-template-columns:1fr 320px;gap:22px;margin-top:22px}
    .card{background:linear-gradient(180deg, rgba(255,255,255,0.01), rgba(255,255,255,0.005));padding:18px;border-radius:12px;border:1px solid rgba(255,255,255,0.02)}

    .section-title{display:flex;align-items:center;gap:10px;margin-bottom:12px}
    .section-title h2{font-size:16px;margin:0}
    ul{margin:0 0 12px 18px;color:var(--muted)}
    li{margin:8px 0}

    pre{background:rgba(2,6,23,0.6);padding:12px;border-radius:8px;overflow:auto;color:#cfefff;font-size:13px}

    .tech{display:flex;flex-wrap:wrap;gap:10px}
    .pill{background:rgba(255,255,255,0.02);padding:8px 10px;border-radius:999px;font-size:13px;color:var(--muted);border:1px solid rgba(255,255,255,0.02)}

    code.inline{background:rgba(255,255,255,0.02);padding:2px 6px;border-radius:6px;font-family:ui-monospace, SFMono-Regular, Menlo, Monaco, 'Roboto Mono', 'Courier New';}

    .actions{display:flex;gap:8px;margin-top:16px}
    .btn{background:linear-gradient(90deg,var(--accent),var(--accent-2));padding:10px 14px;border-radius:10px;color:white;font-weight:600;border:none;cursor:pointer;box-shadow:0 6px 20px rgba(7,16,38,0.6)}
    .btn.ghost{background:transparent;border:1px solid rgba(255,255,255,0.04);color:var(--muted);box-shadow:none}

    .right .meta{color:var(--muted);font-size:14px}
    .muted{color:var(--muted)}

    footer{margin-top:18px;color:var(--muted);font-size:13px;text-align:center}

    @media (max-width:900px){
      .grid{grid-template-columns:1fr}
      .badges{display:none}
    }
  </style>
</head>
<body>
  <div class="container">
    <header>
      <div class="logo">IR</div>
      <div>
        <h1>🚆 Terminal-Based IRCTC Booking System (Java)</h1>
        <p class="lead">A simple terminal-based IRCTC simulation built in Java — demonstrates OOP, in-memory data handling, and CLI interaction.</p>
      </div>

      <div class="badges">
        <div class="badge">Java</div>
        <div class="badge">CLI</div>
        <div class="badge">Beginner</div>
      </div>
    </header>

    <div class="grid">
      <main class="card">
        <div class="section-title"><h2>✨ Overview</h2></div>
        <p class="muted">This project mimics a simplified IRCTC workflow: register users, login, search trains by source/destination, book and view tickets — all through the terminal. It's ideal for practice projects and learning Core Java essentials.</p>

        <div style="margin-top:16px">
          <div class="section-title"><h2>🧩 Features</h2></div>
          <div style="display:grid;grid-template-columns:1fr 1fr;gap:12px">
            <ul>
              <li><strong>User Management</strong>
                <ul class="muted"><li>Register new users</li><li>Login with validation</li><li>Prevent duplicate usernames</li></ul>
              </li>
              <li><strong>Train Management</strong>
                <ul class="muted"><li>View available trains</li><li>Search by source & destination</li><li>Display train ID, name, route, seats</li></ul>
              </li>
            </ul>

            <ul>
              <li><strong>Ticket Booking</strong>
                <ul class="muted"><li>Book tickets for registered users</li><li>Generate ticket details</li><li>View & cancel tickets</li></ul>
              </li>
              <li><strong>CLI UI</strong>
                <ul class="muted"><li>Simple text-based menu</li><li>Clear examples & prompts</li></ul>
              </li>
            </ul>
          </div>
        </div>

        <div style="margin-top:16px">
          <div class="section-title"><h2>⚙️ Tech Stack & Concepts</h2></div>
          <div class="tech">
            <span class="pill">Java (Core)</span>
            <span class="pill">OOP — Classes & Inheritance</span>
            <span class="pill">HashMap (In-memory store)</span>
            <span class="pill">Scanner (Input)</span>
            <span class="pill">Terminal / CLI</span>
          </div>
        </div>

        <div style="margin-top:16px">
          <div class="section-title"><h2>🚀 How to Run</h2></div>
          <p class="muted">Clone, compile, and run from terminal:</p>
          <pre>git clone https://github.com/&lt;your-username&gt;/terminal-irctc-java.git
cd terminal-irctc-java
javac *.java
java Main</pre>
        </div>

        <div style="margin-top:16px">
          <div class="section-title"><h2>📸 Example Output</h2></div>
          <pre>===== Welcome to IRCTC Terminal App =====
1. Register
2. Login
3. Exit

Enter choice: 1
Enter Username: krish
Enter Password: 1234
Enter Full Name: Krish Jindal
Enter Contact: 9999999999
Registration Successful!
Welcome: Krish Jindal!

===== Main Menu =====
1. Search Train
2. Book Ticket
3. View Ticket
4. View All Trains
5. Cancel Ticket
6. Logout</pre>
        </div>

        <div style="margin-top:16px">
          <div class="section-title"><h2>🎯 Learning Objectives</h2></div>
          <ul class="muted">
            <li>Understand structure of a CLI-based Java application</li>
            <li>Manage user sessions & in-memory data</li>
            <li>Design modular code for readability and reusability</li>
          </ul>
        </div>

        <div style="margin-top:16px">
          <div class="section-title"><h2>💡 Future Improvements</h2></div>
          <ul class="muted">
            <li>Integrate persistent storage (MySQL / MongoDB)</li>
            <li>Implement booking history </li>
            <li>File-based data persistence across runs</li>
            <li>Realistic fare logic</li>
          </ul>
        </div>

      </main>

      <aside class="right card">
        <div style="display:flex;justify-content:space-between;align-items:start">
          <div>
            <h3 style="margin:0">📄 Project Summary</h3>
            <div class="meta" style="margin-top:8px">Terminal-based IRCTC simulator written in Java. Lightweight and beginner-friendly.</div>
          </div>
        </div>

        <div style="margin-top:12px">
          <div class="section-title"><h2>🔧 Quick Commands</h2></div>
          <pre>Clone repo
Compile
Run: java Main</pre>
        </div>

        <div style="margin-top:12px">
          <div class="section-title"><h2>👨‍💻 Author</h2></div>
          <div class="muted">Krish Jindal<br>B.Tech Student | Aspiring Simulation Engineer</div>
        </div>

        <div style="margin-top:12px">
          <div class="section-title"><h2>📎 Extras</h2></div>
          <div class="muted">Want a GitHub-ready <code class="inline">README.md</code> or a React-based project page? Click below.</div>
          <div class="actions">
            <button class="btn">Download HTML</button>
            <button class="btn ghost">Get README.md</button>
          </div>
        </div>

      </aside>
    </div>

    <footer>Made with ❤️ • Terminal IRCTC — Example project for learning Java • </footer>
  </div>
</body>
</html>
