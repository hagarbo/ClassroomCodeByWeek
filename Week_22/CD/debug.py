import sys

def remove_html_markup(s):
    tag = False
    quote = False
    out = ""

    for c in s:
            if c== '<' and not quote:
                  tag = True
            elif c == '>' and not quote:
                  tag = False
            elif c == '"' or c == "'" and tag:
                  quote = not quote
            elif not tag:
                  out = out + c
    return out

def traceit(frame, event, arg):
    if event == "line":
        filename = frame.f_code.co_filename
        lineno = frame.f_lineno
        print(open(filename).readlines()[lineno - 1],)
    return traceit

sys.settrace(traceit)
s = remove_html_markup('"<')
sys.settrace(None)

print(remove_html_markup('"<b>foo</b>"'))
print(remove_html_markup("'foo'"))

#Todavia tenemos un bug -> se devuelve cadena vacia
print(remove_html_markup('<a href="don\'t">link</a>'))