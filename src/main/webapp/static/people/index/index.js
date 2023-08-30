document.addEventListener("DOMContentLoaded", function () {
    const personBlocks = document.querySelectorAll('.person');

    personBlocks.forEach(personBlock => {
        personBlock.addEventListener('click', () => {
            const link = personBlock.querySelector('.person-link');
            if (link) {
                window.location.href = link.getAttribute('href');
            }
        });
    });

    const peopleContainer = document.querySelector('.people');
    const people = Array.from(document.querySelectorAll('.person'));

    const sortByNameButton = document.getElementById('sortByName');
    const sortByDateButton = document.getElementById('sortByDate');

    sortByNameButton.addEventListener('click', () => {
        const sortedPeople = _.sortBy(people, person => person.querySelector('.name').textContent);
        peopleContainer.innerHTML = '';
        sortedPeople.forEach(person => peopleContainer.appendChild(person));
    });

    sortByDateButton.addEventListener('click', () => {
        const sortedPeople = _.sortBy(people, person => person.querySelector('.birthdate').textContent);
        peopleContainer.innerHTML = '';
        sortedPeople.forEach(person => peopleContainer.appendChild(person));
    });
});