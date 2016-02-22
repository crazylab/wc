var child_process = require('child_process');
var exec = child_process.exec;
var child = child_process.child;

//run test command : node test.js YourClass
//test file name shoud be YourClassTest.java

//folder structure should have lib, src, out, test

var showErr = function(error){
    if(error.code == 'ENOENT'){
        var message = [error.path, ' Not found in the current directory'].join('');
        console.log('-->Error: '+message);
    }
}

var showOutput = function (error, stdout, stderr){
    stdout && console.log(stdout);
    if(stderr!= '')
        console.log('-->Error: '+stderr);
    if(error !== null)
        showErr(error);
}
var compile_and_run = function(){
    var arguements = process.argv.slice(2);

    var main = arguements[0] || 'Main';
    var Class = main.split('.')[0];
    var test = Class + 'Test.java';
    var executable = Class + 'Test';

    var removeExistingClass = 'rm -f out/*.class'
    exec(removeExistingClass);

    var compileMain = 'javac -cp "src" -d out src/' + main + '.java';
    var compileTest = 'javac -cp "src:lib/junit-4.12.jar" -d out test/' + test;
    var runTest = 'java -cp "out:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore ' + executable;
    var command = compileMain + ' && ' + compileTest + ' && ' + runTest;
    exec(command, showOutput);

    console.log('Executing the following command:');
    console.log(compileMain);
    console.log(compileTest);
    console.log(runTest);
    console.log('-----------------------------------------------------------------------------');

}
compile_and_run();
