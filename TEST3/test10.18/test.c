
#include<stdio.h>
#include<string.h>
#include<assert.h>	
char my_strcpy(char* dest, const char*src){
	char *ret = dest;
	assert(dest != NULL);
	assert(src != NULL);
	while (*dest++ = *src++){
		;
	}
	return ret;
}
int my_strlen(const char *str)
{
	int count = 0;
	assert(str != NULL);  //╤оят
	while (*str++){
		count++;
	}
	return count;
}
int main()
{
	char arr[] = "hello";
	int ret = my_strlen(arr);
	printf("%d", ret);
	system("pause");
	return 0;
}