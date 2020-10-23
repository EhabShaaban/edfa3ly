### Adding 6pm Product 
```- TestCase ID: 1```
```- TestCase Priority: High```
```- Module: edfa3ly cart```
```- Designed by: Ehab S. Feki```

#### Objective
User can add the given item to edfa3ly cart and specific data will be auto-populated
#### Pre-condition
User must have a valid URL that belongs to automated shop (6pm shop)
#### Test Script
1. Navigate to: https://www.edfa3ly.com/cart
> Expected result: Navigated to edfa3ly cart successfully
2. Enter URL in *item URL* text box
> Expected Result: The following data will be auto-populated:
>> 1. Category field will be set to the corresponding category
>> 2. Name field will be set to the actual name of the product
>> 3. Color will be populated with a retrieved list of color data and user will be able to select color from a drop-down list
>> 4. Size will be populated with a retrieved list of size data and user will be able to select size from a drop-down list
>> 5. Price will be populated according to size and color selected
