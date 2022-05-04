//JQuery tasks
    $(document).ready ( function () {
        // declare a counter to count students' records
        var counter = 0;

        
        // input validation
        $("#record").click(function () {
            // declare a testcore to save student score
            var testScore = { 
                name: "",
                math: 0,
                physical: 0,
                chemistry: 0
            };

            // declare a blankcounter to count blanks
            var blankCounter = 0;

            $(".input").each(function () {
                if (this.value === "") {
                    ++blankCounter;
                } else {
                    // Add value back to testScore variable
                    var key = this.name;
                    testScore[key] = this.value;
                }
            });

            if (blankCounter != 0) {
                alert("Vui Lòng Nhập Đủ Các Trường!");
            } else {
                // Increase counter by 1
                ++counter;

                // Clear all input field
                $(".input").val("");

                // Add records and ids/classes
                var markup = `<tr><td>${counter}</td><td>${testScore.name}</td><td>${testScore.math}</td><td>${testScore.physical}</td><td>${testScore.chemistry}</td><td>?</td></tr>`;

                $("#myTab").append(markup);

                $("#myTab tr:last").attr("id",`tr${counter}`);
                $("#myTab tr:last td:gt(1)").addClass('mark');
                $("#myTab tr:last td:last").removeClass('mark');
                $("#myTab tr:last td:last").addClass('aveMark');
            }
        });

        // calculate average marks
        $("#averageMarkCalc").click(function () {
            $(".aveMark").each(function(){
                var aveMark = 0.0, sum = 0.0;
                
                $(this).siblings(".mark").each(function (){
                    var val = parseFloat($(this).text());
                    console.log(val);
                    if (!isNaN(val)) {
                        sum += val;
                    }
                });

                aveMark = (sum/3).toFixed(1);

                $(this).text(aveMark);
            });
        });

        // turn red on who is a great student
        $("#greatStudIdentify").click(function () {
            $(".aveMark").each(function(){
                if (parseFloat($(this).text()) >= 8.0) {
                    $(this).siblings().css("color","red");
                    $(this).css("color","red");
                }
            });
        });

    });
