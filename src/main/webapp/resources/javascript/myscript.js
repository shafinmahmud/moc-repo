//$(document).ready(function(){
//		
//	
//	window.alert("ok");
//		var recoveryEmailForm = $('#recoveryEmailForm');
//		var recoveryMessage = $('#recoveryMessage');
//		
//		recoveryEmailForm.on('submit',function(){
//			
//			
//			var email = $('#recoveryEmail').val();	
//			
//			if(email == null || email == ""){
//				recoveryMessage.text("Cannot be empty");
//				return;
//			}
//	
//			console.log(email);
//			$.ajax({
//				
//				url: '${pageContext.request.contextPath}/mail/recoveryemail',
//				type:'POST',
//				data: $(this).serialize(),
//				success: function(response){
//					if(response=="ok"){
//						recoveryMessage.text("An email has been sent to your account").removeClass("text-danger").addClass("text-success");
//					}
//					
//				},
//				error : function(data,status,er) {
//					
//					recoveryMessage.text("Something went wrong!").removeClass("text-success").addClass("text-danger");
//					
//					
//				}
//			});
//		});
//		
//		
//		
//		 
//	});