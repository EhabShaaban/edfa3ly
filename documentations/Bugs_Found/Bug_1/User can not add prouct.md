### User can not add product
```Bug ID: 1```
```Priority: High```
```Severity: High```
```Module: edfa3ly cart```
```Reported by: Ehab S. Feki```
```Reported on: 25102020```
```Status: New```
```Environment: Linux/Chrome```

#### Description
Cart crash on adding product quantity more than 5 while clicking *Add item* button, quantity value gets reset to valid value but user can not add item


#### Steps To Reproduce
1. Navigate to: https://www.edfa3ly.com/cart
2. Enter valid URL in *item URL* text box *(not prohibited)*
> URL: https://www.6pm.com/p/product/9409514
3. Select any color and size
4. In the *Quantity* text box enter value more than 5 and click *Add item* before value get set back below 5 to let the error message appear
> Error msg: {"quantity":["Quantity should be 5 piece or less"]}
5. Value gets reset below 5
6. Click *Add item*
>Expected Result: On clicking product should be added to cart list
>Actual Result: User is not able to add new product

> refer to: User can not add prouct.gif
