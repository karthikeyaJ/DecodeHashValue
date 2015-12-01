# DecodeHashValue
For a given secret key this program decodes the hashvalue and prints the output. (Note: Secret key hashing principle is given)

find the secret key below
c832539b393b5416109e6a036828083df0da44745a03abd0c2c6cffb2108327cf64e15aa25c8534b8beb877be138b71bc9544c3d2026c2fd5a850f09fb300a98

First, we generated a series of string prefixes with lengths increasing by 2. For example, if our secret email address was helloworld@karthik.com, we would generate:
he
hell
hellow
hellowor
...
helloworld@karthik.com

Then, for every prefix s, we computed the following hash J:
md5(md5(e) + s + md5(s))         [where + is the string concatenation operator and e is your email address].
Finally, we concatenated all hash strings J to form the long hash above!

For example, for helloworld@karthik.com,
we would compute:
md5(md5('vjangal@syr.edu') + 'he' + md5('he')) + 
md5(md5('vjangal@syr.edu') + 'hell' + md5('hell')) + 
md5(md5('vjangal@syr.edu') + 'hellow' + md5('hellow')) + 
...

For the sake of simplicity, you can assume that our secret key only contains alphanumeric characters and these 4 characters: _.@+
