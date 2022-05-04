// get doc ready before using it
$(document).ready(function(){

    // update headlines news from API website whenever the page has loaded
    $(window).on('load', function () {
        $.get("https://gnews.io/api/v4/top-headlines?token=7413a9225da7bc601bbd542ca45247d5&lang=en", function (data) {
            showingHeadlinesNews(data);
        });
    });

    // search button effect
    $('#searchButton').click(function(){
        // add spinners effect
        // spinners exist already/ remove class d-none from previous uses
        $("#spinner").removeClass("d-none");

        // getting data from API server
        let search = $("#inputSearching").val();
        let searchBy = $('input[name=flexRadioDefault]:checked').val();
        $.get(`https://gnews.io/api/v4/search?q=example&token=7413a9225da7bc601bbd542ca45247d5&lang=en&in=${searchBy}`,function(data){
            showingSearchingResults(data);
        });
        // data has loaded
        // spinners mode: hidden
        $("#spinner").addClass("d-none");
    })  
    $('#inputSearching').on('keypress',function(e) {
        if(e.which == 13) {//Enter key downed
            e.preventDefault();
            $('#searchButton').click(); //Trigger search button click event
        }
    });

});

function showingHeadlinesNews (data) {
    let counter = 0;
    $("#headlinesNews").children("div").each(function(){

        $(this).children("img").attr("src", data.articles[counter].image);
        
        $(this).find(".card-title").html(`<a href = "${data.articles[counter].url}" target="_blank">${data.articles[counter].title}</a>`);

        $(this).find(".card-text").html(data.articles[counter].description);

        $(this).find("a").attr("href",data.articles[counter].url);

        ++counter;

    });
}

function showingSearchingResults (data) {
    arrLen = data.articles.length;
    for (let i = 0; i < arrLen; i++) {
        $("#offcanvas").find(".offcanvas-body").append(
            `<div id="result${i}">`+
            `<a href="${data.articles[i].url}" target="_blank"><p>${data.articles[i].title}</p></a>`+
            `<p>${data.articles[i].description}</p>`+
            `</div>`
        );
    }
}