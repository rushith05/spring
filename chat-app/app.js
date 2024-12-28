// const firebaseConfig = {
//     apiKey: "YOUR_FIREBASE_API_KEY",
//     authDomain: "YOUR_FIREBASE_AUTH_DOMAIN",
//     databaseURL: "YOUR_FIREBASE_DATABASE_URL",
//     projectId: "YOUR_FIREBASE_PROJECT_ID",
//     storageBucket: "YOUR_FIREBASE_STORAGE_BUCKET",
//     messagingSenderId: "YOUR_FIREBASE_SENDER_ID",
//     appId: "YOUR_FIREBASE_APP_ID"
//   };
  
//   // Initialize Firebase
//   firebase.initializeApp(firebaseConfig);
//   const auth = firebase.auth();
//   const database = firebase.database();
  
//   const authContainer = document.getElementById("auth-container");
//   const chatContainer = document.getElementById("chat-container");
//   const emailInput = document.getElementById("email");
//   const passwordInput = document.getElementById("password");
//   const authAction = document.getElementById("auth-action");
//   const toggleAuth = document.getElementById("toggle-auth");
//   const authTitle = document.getElementById("auth-title");
//   const logoutButton = document.getElementById("logout");
//   const messagesContainer = document.getElementById("messages");
//   const messageInput = document.getElementById("message-input");
//   const sendMessageButton = document.getElementById("send-message");
  
//   let isSignup = false;
  
//   toggleAuth.addEventListener("click", () => {
//     isSignup = !isSignup;
//     authTitle.textContent = isSignup ? "Signup" : "Login";
//     authAction.textContent = isSignup ? "Signup" : "Login";
//     toggleAuth.textContent = isSignup ? "Already have an account? Login" : "Don't have an account? Signup";
//   });
  
//   authAction.addEventListener("click", async () => {
//     const email = emailInput.value;
//     const password = passwordInput.value;
//     try {
//       if (isSignup) {
//         await auth.createUserWithEmailAndPassword(email, password);
//       } else {
//         await auth.signInWithEmailAndPassword(email, password);
//       }
//       authContainer.classList.add("hidden");
//       chatContainer.classList.remove("hidden");
//       loadMessages();
//     } catch (error) {
//       alert(error.message);
//     }
//   });
  
//   logoutButton.addEventListener("click", async () => {
//     await auth.signOut();
//     authContainer.classList.remove("hidden");
//     chatContainer.classList.add("hidden");
//   });
  
//   sendMessageButton.addEventListener("click", () => {
//     const message = messageInput.value;
//     if (!message) return;
  
//     const userId = auth.currentUser.uid;
//     const email = auth.currentUser.email;
  
//     database.ref("messages").push({
//       userId,
//       email,
//       message,
//       timestamp: Date.now(),
//     });
  
//     messageInput.value = "";
//   });
  
//   function loadMessages() {
//     database.ref("messages").on("value", (snapshot) => {
//       messagesContainer.innerHTML = "";
//       snapshot.forEach((childSnapshot) => {
//         const data = childSnapshot.val();
//         const messageElement = document.createElement("div");
//         messageElement.textContent = `${data.email}: ${data.message}`;
//         messagesContainer.appendChild(messageElement);
//       });
//     });
//   }
  