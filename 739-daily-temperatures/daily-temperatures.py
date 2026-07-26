class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        st=[]
        st.append(0)
        for i in range(1, len(temperatures)):
            while len(st)>0  and temperatures[st[-1]]<temperatures[i]:
                x=st.pop()
                temperatures[x] = i-x
            st.append(i)
        i=len(temperatures)-1
        while len(st)>0:
            temperatures[st.pop()]=0
            i -= 1
        return temperatures
        