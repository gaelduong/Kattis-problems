#include <cstdio>
#include <algorithm>

using namespace std;

int main(){
    int n;
    int b;
    int a[5000000];
    
    while(true)
    {
        int L = 1;
        int H = 0;
        int M;
        
        scanf("%d %d", &n, &b);
        if(n==-1)
        {
            break;
        }
        
        for(int i = 0;i<n;++i)
        {
            scanf("%d",&a[i]);
            if(H <= a[i])
            {
                H = a[i];
            }
            
        }
        
        while(L<H)
        {
            int T = 0;
            int s = L+H;
            M = s >> 1;
            
            
            for(int i = 0;i < n;++i)
            {
                int diff = (M + a[i] - 1);
                diff = diff/M;
                T = T + diff ;
            }
            
            if(T>b)
            {
                M++;
                L = M;
            }
            else if(T<=b)
            {
                H = M;
            }
        }
        
        printf("%d\n",L);
    }
    
    return 0;
}
