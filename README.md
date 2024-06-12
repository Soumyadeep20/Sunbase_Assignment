# Sunbase_Assignment

************************************************************* 1st Phase *************************************************************

Backend APIs:-
-Create a customer: To create a new customer there have an api . 
                    end point:- /customer/save 
		    Method: POST
                    here we need pass a object as Body(CustomerDTO)
                    the Obect's fields are:-
                          firstName
                          lastName
                          address
                          street
                          city
                          state
                          email
                          phone
                    every field are String      
-Update a customer: To update a new customer there have an api . 
                    end point:- /customer/update
		    Method: PUT
                    here we need pass a Customeer object as Body 
                    
-Get a list of customer (API with pagination sorting and searching ): To Get a list of customer (API with pagination sorting and searching ) there have an api .
                      end point:- /customer/search
		      Method: GET
                      here we need pass Two parameter and their value. their type is String
                      Parameters:
                            searchBy: need to pass parameter to search
                            value: parameter value
                            
-Get a single customer based on ID: To Get a Single  customer  there have an api 
                      end point:- /customer/getById
		      Method: GET
                      here we need pass one parameter and  value. it,s type is String
                      Parameters:
                            id: need to pass the customer UUid
-Delete a customer: To delete a Single  customer  there have an api 
                      end point:- /customer/delete
		      Method: DELETE
                      here we need pass one parameter and  value. it,s type is String
                      Parameters:
                            id: need to pass the customer UUid


Authentication: For authentication here we use JWT Authentication . Which is properly Working
                      To heating "/user/login"   Method: POST
                                  this endpoint with a body we will get a token . which we need to above mentioned endpoint as header to access.
                      Body looks like:-
                      {
	                          "id": "SOUMO",
                            "password": "Soumo54"
                      }
                      Response looks like:-
                      {
                           "jwtToken":  "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJTT1VNTyIsIml...............",
                           "id": "SOUMO"
                      }
                      Header for Uthenticatin will be:-
                            Authorization :  Token_Provided_By_"/user/login



************************************************************* 2nd Phase *************************************************************

1. By heating endpont /sunBase/data Method: GET
               we are need to call a remote API to fetch the customer list and save those customers in my database. If the customer already exists in my database                  then instead of inserting, update it in your database.
  --------Process-------
  By heating Path: https://qa.sunbasedata.com/sunbase/portal/api/assignment_auth.jsp
                      Method: POST
                      Body:
                      {
                             "login_id" : "test@sunbasedata.com",
                             "password" :"Test@123"
                      }
     we get a Bearer Token . which stored in local.and then using this in header and passing Parameter "cmd" and by using our end point
                           /sunBase/data
                           we get the data from path: https://qa.sunbasedata.com/sunbase/portal/api/assignment.jsp. Method: Get
