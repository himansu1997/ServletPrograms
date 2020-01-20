 function  validate(frm){
          let  name;
          let age;
          //set vflag value to "yes" indicating  client side form validations are performed
          frm.vflag.value="yes";
          //emtpty the error messages
          document.getElementById("nameErr").innerHTML="";
          document.getElementById("ageErr").innerHTML="";
          alert("Client side form validations are taking palce");
                    //form validation logic (client side)
          name=frm.pname.value;
          age=frm.page.value;
          if(name==""){
           document.getElementById("nameErr").innerHTML="Person name is required";
             frm.pname.focus();
             return false;
          }
          if(age==""){
                document.getElementById("ageErr").innerHTML="Person age is required";
             frm.page.focus();
             return false;
          }
          else if(isNaN(age)){
            document.getElementById("ageErr").innerHTML="Person age should be numberic value";
            frm.page.focus();
            return false;
          }
          else if(age<=0  || age>125){
           document.getElementById("ageErr").innerHTML="Person age must there in the range 1 thorugh 125";
            frm.page.focus();
            return false;
          }
          return true;
     }//function