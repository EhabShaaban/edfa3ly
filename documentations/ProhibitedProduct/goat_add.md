### Adding Goat Product 
```TestCase ID: 11```
```TestCase Priority: Medium```
```Module: edfa3ly cart```
```Designed by: Ehab S. Feki```

#### Objective
User can not add prohibited items from edfa3ly cart
#### Pre-condition
User must have prohibited URL
> URL: https://www.goat.com/sneakers/shane-sb-premium-light-orewood-brown-cv5500-200
#### Test Script
1. Navigate to: https://www.edfa3ly.com/cart
> Expected Result: Navigated to edfa3ly cart successfully
2. Enter URL in *item URL* text box
> Expected Result: Error msg. will be displayed saying *we apologize, store is not available at this moment*. User will not be able to add the item.
