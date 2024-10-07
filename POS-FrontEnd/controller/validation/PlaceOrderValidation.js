$(document).ready(function() {
    $('#inputCash').on('input', function() {
        const total = parseFloat($('#inputTotal').val());
        const cash = parseFloat($(this).val());

        if (cash < total) {
            $(this).attr("style", "border-color: red !important;");
            $('#balance').val(0);
            // alert('Cash cannot be less than the total amount.');
        } else {
            $(this).attr("style", "border-color: white !important;");
            const balance = cash - total;
            $('#balance').val(balance.toFixed(2));
        }
    });

    $('#inputCash').on('keydown', function(e) {
        if (e.key === 'Enter') {
            const total = parseFloat($('#inputTotal').val());
            const cash = parseFloat($(this).val());

            if (cash < total) {
                e.preventDefault();
                alert('Cash less than the total amount !');
                $('#balance').val('');
                $(this).focus();
            } else {
                const balance = cash - total;
                $('#balance').val(balance.toFixed(2));
            }
        }
    });
});