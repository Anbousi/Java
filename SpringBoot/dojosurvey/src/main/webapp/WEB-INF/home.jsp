<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/home.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <title>Dojo Servey</title>
        <script>
            $(document).ready(function(){
                var radioValue = 'No'
                $('.check').fadeOut();
                $('#y').click(function(){
                    $('.check').fadeIn();$('.y').addClass('green');$('.n').removeClass('red');
                    radioValue = $("input[name='radio']:checked").val(); $('.check').attr('required');
                    console.log(radioValue);
                });
                $('#n').click(function(){
                    $('.check').fadeOut();$('.y').removeClass('green');$('.n').addClass('red');
                    radioValue = $("input[name='radio']:checked").val();$('.check').removeAttr('required');
                    console.log(radioValue);
                });
    
            })
        </script>
    </head>
    
    <body>
        <main>
            <form action="/data" method="POST" class="form-group">
                <table class="table table-sm">
                    <tr>
                        <td><label for="name">Your Name:</label></td>
                        <td><input type="text" id="name" name="name" class="input" required></td>
                    </tr>
                    <tr>
                        <td><label for="location">Dojo Location:</label></td>
                        <td>
                            <select name="location" id="location" required>
                                <option value="" selected hidden>Please Select</option>
                                <option value="San Jose">San Jose</option>
                                <option value="Arlington">Arlington</option>
                                <option value="Los Angeles">Los Angeles</option>
                                <option value="Orange County">Orange County</option>
                                <option value="Berkeley">Berkeley</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="language">Favorite Language:</label></td>
                        <td>
                            <select name="language" id="language" required>
                                <option value="" selected hidden>Please Select</option>
                                <option value="Python">Python</option>
                                <option value="Java">Java</option>
                                <option value="Mern">Mern</option>
                                <option value="c++">c++</option>
                                <option value="c#">c#</option>
                            </select>
                        </td>
                    </tr>
                </table>
                <!-- <p>Do you want to recieve news?</p>
                <div class="yes-no">
                    <input type="radio" name="radio" value="Yes" id="y" required>
                    <label for="y" class="y">Yes</label><br>
                    
                    <input type="radio" name="radio" value="No" id="n" required>
                    <label for="n" class="n">No</label>
                </div>
                <div id="news">
                    <input type="checkbox" name="check" id="check1" class="check" value='Daily'>
                    <label for="check1" class="check">Daily News</label><br>
                    
                    <input type="checkbox" name="check" id="check2" class="check" value='Weekly'>
                    <label for="check2" class="check">Weekly News</label><br>
                    
                    <input type="checkbox" name="check" id="check3" class="check" value='Monthly'>
                    <label for="check3" class="check">Monthly News</label><br><br>
                </div><br>
                <label for="comment" id="l-comment" >Comment (optional) &#8645;</label><br>
                <input type="text" name="comment" id="comment" class="input"><br> -->
                <p>Comment (optional)</p>
                <textarea name="comment" id="comment" cols="30" rows="10"></textarea>
    
                <input type="submit" value="Creat User" id="submit" class="btn btn-success input">
            </form>
        </main>
        
    </body>
    </html>