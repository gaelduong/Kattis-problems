#include<bits/stdc++.h>
using namespace std;
int main(){
    string A;
    string B;
    int C[200000];
    
    while(getline(cin,A)){
        getline(cin,B);
        int y=0;
        int x=0;
        
        while(B.find(A,x)!=-1&&x<B.size())
        {
            C[y++]=B.find(A,x);
            x=C[y-1]+1;
        }
        for(int i=0;i<y;i++)
        {
            if(i==y-1) printf("%d%c",C[i],'\n');
            else printf("%d%c",C[i],' ');
        }
    }
    return 0;
}
