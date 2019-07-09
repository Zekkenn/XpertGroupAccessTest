/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

api = (function(){
   return {
       solveData : function(){
           $.ajax({
		url : "/public/services/solution",
		type : "POST",
		data : JSON.stringify({ data : api.inputCode.getValue()}),
		contentType: "application/json"
            }).then(
                    function(response){
                        api.outputCode.setValue(response);
                    },
                    function(response){
                        alert(response.responseText);
                    }
            );
       }
   } 
})();

$(document).ready(function(){
    var inputCode = CodeMirror.fromTextArea(document.getElementById('input'), {
        mode: "javascript",
        id : "inputCode",
        lineNumbers: true
    });
    inputCode.save();

    var outputCode = CodeMirror.fromTextArea(document.getElementById('output'), {
        mode: "javascript",
        id : "outputCode",
        lineNumbers: true
    });
    outputCode.save();
    
    api.inputCode = inputCode;
    api.outputCode = outputCode;
    
});