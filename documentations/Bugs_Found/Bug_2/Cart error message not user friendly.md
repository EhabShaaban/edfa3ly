### Cart error message not user friendly
```Bug ID: 2```
```Priority: High```
```Severity: Low```
```Module: edfa3ly cart```
```Reported by: Ehab S. Feki```
```Reported on: 25102020```
```Status: New```
```Environment: Linux/Chrome```

#### Description
When adding products error message are descriptive but not user friendly instead JSON is displayed to the user

#### Steps To Reproduce
1. Navigate to: https://www.edfa3ly.com/cart
2. Enter valid URL in *item URL* text box *(not prohibited)*
> URL: https://www.shein.com/CUCCOO-The-Everyone-Sneakers-p-1187851-cat-1913.html
3. Select any color and size
4. Enter *Quantity* more than 5
> The following JSON will appear: {"quantity":["Quantity should be 5 piece or less"]}
