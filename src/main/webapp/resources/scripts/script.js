document.addEventListener("DOMContentLoaded",function () {
    //default radius after loading page
    setRadius(2);
    canvas.addEventListener("click", mouseHandler);
    function mouseHandler(event) {
        if (currentRadius === null) {
            return;
        }
        const rect = canvas.getBoundingClientRect();
        mouse.x = event.clientX - rect.left;
        mouse.y = event.clientY - rect.top;
        return clickingProcessing(mouse.x, mouse.y);
    }
    function clickingProcessing(clicked_x, clicked_y) {
        let x = parseFloat((((clicked_x - w / 2) / hatchGap) / 2) * currentRadius).toFixed(3);
        let y = parseFloat((-((clicked_y - h / 2) / hatchGap) / 2) * currentRadius).toFixed(3);
        sendCoordinates(x, y)
        return {
            x: x,
            y: y,
        }
    }
});

let xVal = document.getElementById("clicking-form:xHidden");
let yVal = document.getElementById("clicking-form:clickingYHidden");
let sbButton = document.getElementById('clicking-form:click-submit');
let y_ACTUAL = document.getElementById('main-form:yValue');

/**
 * Clicking hidden button with some processing :
 * 1) direct click
 * 2) Draw new point(for now old points)
 */
function submitHiddenClick(){
    sbButton.click();
    drawAllPointsFromResultTable();
}

function sendCoordinates(xValue,yValue){
    xVal.value = xValue;
    y_ACTUAL.value = yValue;
    yVal.value = yValue;
    submitHiddenClick();
}


/**
 * Drawing old points from the table
 * Warning: doesn't include the last one
 */
function drawAllPointsFromResultTable(){
    let i = 0;
    while (true){
        let x = document.getElementById('results-table:' + i + ':xResult');
        if(x==null)
            break;
        let y = document.getElementById('results-table:'+ i + ':yResult');
        let result = document.getElementById('results-table:' + i + ':hitResult');
        let isHit = result.innerHTML === '✅';
        console.log("current input: ",x.innerHTML,y.innerHTML,result.innerHTML,isHit);
        printDotOnGraph(x.innerHTML,y.innerHTML,isHit);
        i++;
    }
    console.log('Всего отрисовано: ' + i);
}
