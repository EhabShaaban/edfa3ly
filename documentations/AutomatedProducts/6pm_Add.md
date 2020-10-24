### Adding 6pm Product 
```TestCase ID: 1```
```TestCase Priority: High```
```Module: edfa3ly cart```
```Designed by: Ehab S. Feki```

#### Objective
User can add the given item to edfa3ly cart and specific data will be auto-populated
#### Pre-condition
User must have a valid URL that belongs to automated shop (6pm shop)
> URL: https://www.6pm.com/p/product/9409514
#### Test Script
1. Navigate to: https://www.edfa3ly.com/cart
> Expected Result: Navigated to edfa3ly cart successfully
2. Enter URL in *item URL* text box
> Expected Result: The following data will be auto-populated:
>> 1. Category field will be set to the corresponding category (can not be changed)
>> 2. Name field will be set to the actual name of the product (can not be changed)
>> 3. Color will be populated with a retrieved list of color data and user will be able to select color from a drop-down list (changeable)
>> 4. Size will be populated with a retrieved list of size data and user will be able to select size from a drop-down list (changeable)
>> 5. Price will be dynamically changed according to size and color selected (changeable)
>> 6. Quantity populated should not be more than 5
3. Click on *Notes and additional info* if needed to add the following data:
	1. Charges by seller
	2. Extra notes
	3. Choose suitable option from *If item is not available* list
> Expected Result: Data entered successfully
4. Click on *Add item*
> Expected Result: Item added successfully on cart with previously entered details.
> Total receipt price will be populated besides cart icon on nav bar
