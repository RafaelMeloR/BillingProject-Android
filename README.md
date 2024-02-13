# BillingProject-Android

Create an Android Project named BillingProject to add more widgets to layout resource 
defining UI activity. Add five EditText widgets, (two TextView widgets, two first
Button widgets) placed within vertical LinearLayout, (two last Button widgets
Next and Prev) placed within horizontal LinearLayout to allow mobile user to read 
billing information stored into collection of array objects and displaying each element within 
TextView widget as shown hereafter in Figure.
b) Create Billing class which represents Model class of MVC pattern and defines data 
attributes of every billing record with the following fields: client_id (int), client_name 
(string), product_Name (string), prd_Price (double), prd_Qty (int).
• Add default constructor, constructor with parameters, setters and getters.
420-952-VA App.Dev.2 (Mobile) 4/5 CEGEP VANIER COLLEGE 2024
• Add a method within Billing class called CalculateBilling() to calculate the total of 
billing such as:
T_Billing = (prd_Price* prd_Qty) + (prd_Price*prd_Qty)* Fed_Tax + (prd_Price*prd_Qty)* Prv_Tax
Fed_Tax and Prv_Tax are static variables set to Fed_Tax=0.075, Prv_Tax=0.06.
c) Override methods onStart(), onResume(), onPause(), onStop(), and 
onDestroy(). Press Home button and rotate mobile device to see these methods being 
invoked by Android OS in Log viewer tool of Android Studio.
d) Add button “Total Input Billing” to display total billing related to mobile end-user 
inputs into TextView widget and within device screen layout using Toast class as shown 
hereafter in Figure.
e) Add button “Total Record Billing” to display total billing related to element of 
Billing array of objects and displays billing info within TextView widget and within 
device screen layout using Toast class as shown hereafter in Figure.
Populate array elements to be set to the following record values:
(105, "Johnston Jane", "Chair", 99.99, 2) 
(108, "Fikhali Samuel", "Table", 139.99, 1)
(113, "Samson Amina", "KeyUSB", 14.99, 2) 
f) Add button “Next Billing” to skip through each next element of Billing array of 
objects and displays billing info within TextView widget as shown hereafter in Figure.
g) Add button “Prev Billing” to skip through each previous element of Billing array of 
objects and displays billing info within TextView widget as shown hereafter in Figure.
h) Add landscape layout to BillingProject so mobile user will get that layout when she rotates 
her mobile device as shown in Figure hereafter. Use appropriate Layout.
i) Use Bundle class object to save currentIndex of array object so that current billing array 
element object will be displayed whatever mobile user chooses as orientation.
