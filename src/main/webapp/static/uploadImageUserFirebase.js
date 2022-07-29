const firebaseConfig = {
    apiKey: "AIzaSyCrJj3CS0P_pLfdCzUOkaspZyQR0Ml6WRI",
    authDomain: "techshop-50634.firebaseapp.com",
    projectId: "techshop-50634",
    storageBucket: "techshop-50634.appspot.com",
    messagingSenderId: "202075120609",
    appId: "1:202075120609:web:6192949ec6e1fb298768a0",
    measurementId: "G-WTYD0D0YQJ"
};

// Initialize Firebase
firebase.initializeApp(firebaseConfig);

document.getElementById('file').addEventListener('change', (event) => {
    const file = event.target.files[0];
    const storageRef = firebase.storage().ref('images/' + file.name);

    storageRef.put(file).on('state_changed', (snapshot) => {
        const progress = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
        console.log(progress);
        const progressBar = document.getElementById('progress_bar');
        progressBar.value = progress;

    });
    // Create a reference to the file we want to download
    setTimeout(() => {getURLImage(storageRef)},5*1000);

});
function getURLImage(storageRef) {
    storageRef.getDownloadURL().then(function(url){
        const image = document.getElementById('image');
        console.log(url);
        image.src = url
        const pathImage = document.getElementById('pathImage');
        pathImage.value = url;
    });
}
