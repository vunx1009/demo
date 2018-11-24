# ShopBack Android Exercise 

### Assumptions

1. The minimum Android API version is supported 19(KitKat).
2. The network is required and the request is always success
3. The best screen size is 5' to display
4. The response always consist of (login, name, bio, location, blog, site_admin) fields.
5. That avatar image size is not too large to show

### Screens design
	The user list screen:
	![](./test/user_list_screen.png)

	The user detail screen:
	![](./test/user_detail_screen.png)
	
### Implementations
	The source code apply MVP model. It easily support to make unit test.
	The network library is used the Fast Android Networking Library
	The most difficult is large image size handling.
