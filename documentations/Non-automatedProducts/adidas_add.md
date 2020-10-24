### Adding Adidas Product 
```TestCase ID: 7```
```TestCase Priority: High```
```Module: edfa3ly cart```
```Designed by: Ehab S. Feki```

#### Objective
User can add the given item to edfa3ly cart and user will enter required data manually: Caregory, Item Name, Quantity, Unit Price, Color & Size
#### Pre-condition
User must have a valid URL that belongs to automated shop (Adidas shop)
> URL: https://www.adidas.com/us/nite-jogger-shoes/CG5950.html
#### Test Script
1. Navigate to: https://www.edfa3ly.com/cart
> Expected Result: Navigated to edfa3ly cart successfully
2. Enter URL in *item URL* text box
3. Fill in the following data:
	1. Select the corresponding category from *Category* field
	2. Fill in prouct name in *Item Name* text box
	3. Fill in product quantity in *Quantity* field (must not exceed 5)
	4. Fill in product price in *Unit Price* text box
	5. Fill in product color in *Color* text box
	6. Fill in product size in *Size* text box
> Expected Result: Data entered successfully
4. Click on *Notes and additional info* if needed to add the following data:
	1. Charges by seller
	2. Extra notes
	3. Choose suitable option from *If item is not available* list
> Expected Result: Data entered successfully
5. Click on *Add item*
> Expected Result: Item added successfully on cart with previously entered details.
> Total receipt price will be populated besides cart icon on nav bar
