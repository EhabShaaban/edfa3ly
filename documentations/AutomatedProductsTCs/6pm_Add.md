# Adding 6pm Product 

- TestCase ID: 1
- TestCase Priority: High
- Module: edfa3ly cart
- Designed by: <em>Ehab S. Feki</em>

- Objective: User can add the given item to edfa3ly cart and specific data will be auto-populated
- Pre-condition: User must have a valid URL that belongs to automated shop (6pm shop)

- Test Script:

<ul>
<li>User navigate to: https://www.edfa3ly.com/cart</li>
<li>Expected result: Navigated to edfa3ly cart successfully</li>
<li>Enter URL in <em>item URL</em> text box</li>
<li>Expected Result: The following data will be auto-populated:</li>
<li>Category field will be set to the corresponding category</li>
<li>Name field will be set to the actual name of the product</li>
<li>Color will be populated with a retrieved list of color data and user will be able to select color from a drop-down list</li> 
<li>Size will be populated with a retrieved list of size data and user will be able to select size from a drop-down list</li>
<li>Price will be populated according to size and color selected</li>
</ul>	
