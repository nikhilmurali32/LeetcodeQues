class Solution {
    int i = 0; // This is the ONLY global tracker you need now!

    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        char operation = ' ';
        boolean neg_first = false;
        
        while (i < s.length()) {
            char ch = s.charAt(i);
            
            if (ch == ' ') {
                i++;
                continue;
            } 
            else if (ch == ')') {
                // We hit a closing parenthesis. Just return the result!
                // The parent function will automatically resume from this exact 'i'.
                return st.pop();
            } 
            else if (ch == '(') {
                i++; // Step over the '(' to get inside
                
                // Pass the FULL string. The global 'i' guarantees it starts in the right place.
                int b = calculate(s); 
                
                if (operation == '+') {
                    st.push(st.pop() + b);
                } 
                else if (operation == '-') {
                    if (neg_first) {
                        st.push(-1 * b);
                        neg_first = false;
                    } else {
                        st.push(st.pop() - b);
                    }
                } 
                else {
                    st.push(b);
                }
                // Look, ma! No more last_ind math!
                // The recursive call already moved the global 'i' forward for us.
            } 
            else if (ch == '+') {
                operation = '+';
            } 
            else if (ch == '-') {
                if (st.isEmpty()) {
                    neg_first = true;
                }
                operation = '-';
            } 
            else {
                // Multi-digit parsing remains exactly the same
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--; 

                if (operation == '+') {
                    st.push(st.pop() + num);
                } else if (operation == '-') {
                    if (neg_first) {
                        st.push(-1 * num);
                        neg_first = false;
                    } else {
                        st.push(st.pop() - num);
                    }
                } else {
                    st.push(num);
                }
            }
            i++;
        }
        return st.pop();
    }
}