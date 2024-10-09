function displayProfilePic() {
    const input = document.getElementById('photo');
    const img = document.getElementById('profilePic');
    
    if (input.files && input.files[0]) {
      const reader = new FileReader();

      reader.onload = function (e) {
        img.src = e.target.result;
        img.style.display = 'block';
      };

      reader.readAsDataURL(input.files[0]);
    }
  }

  function submitForm() {
    const formData = new FormData(document.getElementById('profileForm'));

    for (const pair of formData.entries()) {
      console.log(pair[0] + ': ' + pair[1]);
    }
  }