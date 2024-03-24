function makeBooking() {
    const customerName = document.getElementById("customer-name").value;
    const selectedService = document.getElementById("service").value;
    const bookingDate = document.getElementById("booking-date").value;

    if (!customerName || !selectedService || !bookingDate) {
        alert("Please fill in all fields.");
        return;
    }

    const bookingData = {
        customerName,
        serviceRequired: selectedService,
        bookingDate
    };

    fetch('http://localhost:3000/api/bookings', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(bookingData)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Booking request failed.');
        }
        return response.json();
    })
    .then(data => {
        console.log(data.message); // Confirmation message from the backend
        alert("Booking confirmed! Thank you.");
    })
    .catch(error => {
        console.error('Error:', error);
        alert("Failed to make booking. Please try again.");
    });
}
