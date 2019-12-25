from glob import escape

from flask import Flask, request, make_response, render_template  # 引入Flask模块

app = Flask(__name__) # 创建一个应用

@app.route('/')
def index():    # 定义根目录处理器
    return '<h1>Hello World!</h1>'

@app.route('/hello')
def hello():
    return "Hello"

@app.route('/user/<name>')
def user(name):
     return '<h1>Hello, %s! </h1>' % name

@app.route('/user/<name>/<age>')
def user2(name, age):
    return "<h1> Hello, %s, you're %s years old" % (name, age)

@app.route('/login', methods=['GET', 'POST'])
def login():
    if request.method == 'POST':
        return do_the_login()
    else:
        return show_the_login_form()

def do_the_login():
    return "do the login"

def show_the_login_form():
    return "show the login form"

@app.route('/users/', defaults={'page': 1})
@app.route('/users/page/<int:page>')
def show_users(page):
    return request.url

@app.route('/job/')
@app.route('/work/')
def show_works():
    return 'This is works page'

@app.before_first_request
def first_quest():
    print("run before first request")

@app.route('/post/<int:post_id>')
def show_post(post_id):
    # show the post with the given id, the id is an integer
    return 'Post %d' % post_id

@app.route('/path/<path:subpath>')
def show_subpath(subpath):
    # show the subpath after /path/
    return 'Subpath %s' % escape(subpath)

@app.errorhandler(404)
def not_found(error):
    resp = make_response(render_template('error.html'), 404)
    resp.headers['X-Something'] = 'A value'
    return resp

if __name__ == '__main__':
    app.run() # 启动服务
