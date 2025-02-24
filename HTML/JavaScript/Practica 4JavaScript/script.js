// Elementos del html almacenados en constantes
const taskForm = document.getElementById('taskForm');
const taskInput = document.getElementById('taskInput');
const taskList = document.getElementById('taskList');
const showAllButton = document.getElementById('showAll');
const showPendingButton = document.getElementById('showPending');
const showCompletedButton = document.getElementById('showCompleted');
const clearCompletedButton = document.getElementById('clearCompleted');

// Manejar el formulario para añadir una nueva tarea
taskForm.addEventListener('submit', (event) => {
    event.preventDefault();
    const taskText = taskInput.value.trim();
    if (taskText) {
        addTask(taskText);
        taskInput.value = ''; // Esto limpia el campo de texto
    }
});

// Función para añadir una nueva tarea
function addTask(taskText) {
    const li = document.createElement('li');
    li.classList.add('task');
    
    const span = document.createElement('span');
    span.textContent = taskText;
    span.classList.add('task-text');

    const completeButton = document.createElement('button');
    completeButton.textContent = 'Completar';
    completeButton.classList.add('complete-task');
    completeButton.addEventListener('click', () => {
        li.classList.toggle('completed');
    });

    const deleteButton = document.createElement('button');
    deleteButton.textContent = 'Eliminar';
    deleteButton.classList.add('delete-task');
    deleteButton.addEventListener('click', () => {
        li.remove();
    });

    li.appendChild(span);
    li.appendChild(completeButton);
    li.appendChild(deleteButton);
    taskList.appendChild(li);
}

// Filtros
showAllButton.addEventListener('click', () => {
    const tasks = document.querySelectorAll('.task');
    tasks.forEach(task => task.style.display = 'flex');
});

showPendingButton.addEventListener('click', () => {
    const tasks = document.querySelectorAll('.task');
    tasks.forEach(task => {
        task.style.display = task.classList.contains('completed') ? 'none' : 'flex';
    });
});

showCompletedButton.addEventListener('click', () => {
    const tasks = document.querySelectorAll('.task');
    tasks.forEach(task => {
        task.style.display = task.classList.contains('completed') ? 'flex' : 'none';
    });
});

// Borrar todas las tareas completadas
clearCompletedButton.addEventListener('click', () => {
    const completedTasks = document.querySelectorAll('.task.completed');
    completedTasks.forEach(task => task.remove());
});
