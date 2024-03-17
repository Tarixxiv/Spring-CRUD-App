<h1>Spring CRUD App</h1>
This project is a CRUD (Create, Read, Update, Delete) application built using the Spring Framework for the backend and Angular for the frontend. It provides a seamless interface for managing data stored in an H2 database through a web-based user interface.
<h3>Installation Requirements</h3>
<ul>
   <li>npm</li>
   <li>nginx</li> 
</ul>
<h3>How to run</h3>
<h4>With docker</h4>
<ul>
<li>Run build.sh script in main project directory</li>
<li>run Dockerfile</li>

    sudo docker-compose up
<li>open <a>localhost:8080</a> in an internet browser of your choice</li>
</ul>
<h4>Without docker</h4>
<ul>
<li>Run build.sh script in main project directory</li>
<li>Run modules in order provided below
    <ul>
        <li>aui-star</li>
        <li>aui-planet</li>
        <li>aui-gateway</li>
    <li>aui-angular (run instructions in module's README.md)</li>
    </ul>
</li>
<li>open <a>localhost:4200</a> in an internet browser of your choice</li>
</ul>
