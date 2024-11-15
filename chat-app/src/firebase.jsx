import { initializeApp } from "firebase/app";
import { getAuth } from "firebase/auth";
import { getStorage } from "firebase/storage";
import { getFirestore } from "firebase/firestore";
const firebaseConfig = {
  apiKey: "AIzaSyBGGN7lFofmReLdcwvtdjmAcaKuhBU4EAI",
  authDomain: "chat-app-64daa.firebaseapp.com",
  projectId: "chat-app-64daa",
  storageBucket: "chat-app-64daa.firebasestorage.app",
  messagingSenderId: "1025201837873",
  appId: "1:1025201837873:web:fdd8717859309bffbe4210",
  measurementId: "G-C2B04WF979"
};

export const app = initializeApp(firebaseConfig);
export const auth = getAuth();
export const storage = getStorage();
export const db = getFirestore()