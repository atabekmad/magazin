## List of Problems in Application:

###  Signup Page:	 
* Passwords aren't validated. User is able to enter almost anything including whitespaces and non-latin symbols.
* Whitespace characters don't get stripped off in the EmailField of Signup and Login pages.
* Feature/Bug - only 1 account is allowed to be registered.

###  Login Page:
* Same as with Signup page. No password validation.

###  Search Page:
* Ordered items can be duplicated in Cart if they are ordered more that one time. In this case it's better to represent each item in the Cart followed by number of purchases. For example, Item1(1), Item2(5), Item3(2) and so on.

