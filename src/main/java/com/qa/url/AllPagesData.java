package com.qa.url;

public interface AllPagesData {

	// Interest Payment Step2 health checks
	String systemHealthCheck = " System Health Check";
	String allAllocationsBalancedCheck = " All Allocations Balanced";
	String nimAnalysisCheck = " NIM Analysis";
	String reservesCheck = " Reserves";
	String reserveReleasesCheck = " Reserve Releases";
	String forecastToleranceCheck = " Forecast Tolerance";
	String bridgeLoanRateDifferenceToleranceCheck = " Bridge Loan Rate Difference Tolerance";
	String facilityRateMaxDifferenceToleranceCheck = " Facility Rate Max Difference Tolerance";

	// Interest Payment Step3 Table Header Name
	String priorMonthPaymentTableHeader = "Prior Month Payment";
	String deferralTableHeader = "Deferral";
	String deploymentTableHeader = "Deployment";
	String rateTableHeader = "Rate";
	String dayCountTableHeader = "Day Count";
	String forecastTableHeader = "Forecast";
	String forecastDiffTotalTableHeader = "Forecast Diff (Total)";
	String forecastDiffPercentageTableHeader = "Forecast Diff (%)";

	// Interest Payment Details >> I Button Tool Tip Messages
	String dayCountFraction = "The difference due to the change in day count during the month";
	String lendingRates = "The difference due to the change in the average facility rates";
	String deployment = "The difference due to the change in the average amount deployed in bridge loans over the month";
	String cashInterest = "The difference due to the amount paid as cash interest";
	String interestDeferral = "The difference due to the change in the Deferred Interest C/F balance";

}
